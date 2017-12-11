package protocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by violetMoon on 2017/12/9.
 */
public class ObjectDecoder extends ByteToMessageDecoder{

    private ThreadLocal<Integer> nextStrLengths = new ThreadLocal<>();
    private ThreadLocal<String> currentKeys = new ThreadLocal<>();

    private ThreadLocal<Map<String, String>> datas = new ThreadLocal<>();

    private ThreadLocal<ReadState> states = new ThreadLocal<>();

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("StringMapDecoder.decode");
        ReadState state = states.get();
        if (state == null) {
            state = ReadState.KEY_LEN;
            states.set(state);
        }

        Integer keyLen = null;
        String key = null;
        Integer valueLen = null;
        while (true) {
            switch (state) {
                case KEY_LEN:
                    if (in.readableBytes() < 4)
                        return;
                    keyLen = in.readInt();
                    if (keyLen == -1) { //end
                        Map<String, String> data = datas.get();
                        if (data == null)
                            data = new HashMap<>();
                        out.add(data);

                        clear();
                        return;
                    }
                    if (keyLen >= 0) {
                        nextStrLengths.set(keyLen);
                        states.set(ReadState.KEY);
                        state = ReadState.KEY;
                    } else {
                        System.err.println("error key len, less than zero");
                        clear();
                        return;
                    }
                    //encounter a
                    break;
                case KEY:
                    keyLen = keyLen == null? nextStrLengths.get(): keyLen;
                    if (in.readableBytes() < keyLen)
                        return;
                    // TODO: 2017/12/10
                    byte[] keyBytes = new byte[keyLen];
                    in.readBytes(keyBytes);
                    key = new String(keyBytes);
                    currentKeys.set(key);
                    states.set(ReadState.VALUE_LEN);
                    state = ReadState.VALUE_LEN;
                    break;
                case VALUE_LEN:
                    if (in.readableBytes() < 4)
                        return;
                    valueLen = in.readInt();
                    if (valueLen < 0) {
                        System.err.println("value len error");
                        clear();
                        return;
                    }
                    nextStrLengths.set(valueLen);
                    states.set(ReadState.VALUE);
                    state = ReadState.VALUE;
                    break;
                case VALUE:
                    valueLen = valueLen == null? nextStrLengths.get(): valueLen;
                    if (in.readableBytes() < valueLen)
                        return;
                    byte[] valueBytes = new byte[valueLen];
                    in.readBytes(valueBytes);
                    String value = new String(valueBytes);
                    key = key == null? currentKeys.get(): key;
                    Map<String, String> dataMap = datas.get();
                    if (dataMap == null)
                        dataMap = new HashMap<>();
                    dataMap.put(key, value);
                    datas.set(dataMap);
                    states.set(ReadState.KEY_LEN);
                    state = ReadState.KEY_LEN;
                    break;
            }
        }
    }

    private void clear() {
        states.set(null);
        nextStrLengths.set(null);
        datas.set(null);
        currentKeys.set(null);
    }

    enum ReadState {
         KEY_LEN, KEY, VALUE_LEN, VALUE,
    }

}
