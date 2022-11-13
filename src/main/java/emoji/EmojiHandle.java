package emoji;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;


public class EmojiHandle {
    private static final String path="./src/main/resources/emoji/emoji.json";
    private static final Logger logger = LoggerFactory.getLogger(EmojiHandle.class);
    private static EmojiHandle instance = new EmojiHandle();

    private  Map<String, Emoji> emojiMap;
    private  HashMap<String, String> shortnameToUnicode = new HashMap<>();
    private  HashMap<String, String> unicodeToShortname = new HashMap<>();
    private  HashMap<String, String> shortameToHex = new HashMap<>();

    public static EmojiHandle getInstance() {
        return instance;
    }

    public Map<String, Emoji> getEmojiMap() {
        return emojiMap;
    }
    private void loadEmoji() {

        JsonReader reader;
        try {
            reader = new JsonReader(new FileReader(path));
            emojiMap = gson.fromJson(reader, new TypeToken<Map<String, Emoji>>() {
            }.getType());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            logger.error("emoji.json file is wrong");
        }

        emojiMap.forEach((name, entry) -> {

            String shortname = entry.getShortname();
            String hex = entry.getUnicode();
            String unicode = null;
            if (hex != null && !hex.isEmpty()) {
                unicode = convert(hex);
                entry.setUnicode(unicode);
                entry.setHex(hex);
            }
            //logger.debug("{}", entry);
            if (shortname == null || shortname.isEmpty() || unicode == null || unicode.isEmpty()) {
                return;
            }
            shortnameToUnicode.put(shortname, unicode);
            unicodeToShortname.put(unicode, shortname);
            shortameToHex.put(unicode, hex);
        });

        SHORTNAME_PATTERN = Pattern
                .compile(String.join("|", shortnameToUnicode.keySet().stream().collect(Collectors.toList())));
        UNICODE_PATTERN = Pattern.compile(String.join("|",
                unicodeToShortname.keySet().stream().map(u -> Pattern.quote(u)).collect(Collectors.toList())));
    }
    }
    public Queue<Object> toEmojiAndText(String input){
        Queue<Object> queue = new LinkedList<>();
        Matcher matcher = SHORTNAME_PATTERN.matcher(input);
        int lastEnd = 0;
        while (matcher.find()) {
            String lastText = input.substring(lastEnd, matcher.start());
            if (!lastText.isEmpty())
                queue.add(lastText);
            String m = matcher.group();
            emojiMap.values().stream().filter(entry -> entry.getShortname().equals(m)).forEach(entry -> {
                if (entry.getHex() != null && !entry.getHex().isEmpty()) {
                    queue.add(entry);
                }
            });
            lastEnd = matcher.end();
        }
        String lastText = input.substring(lastEnd);
        if (!lastText.isEmpty())
            queue.add(lastText);
        return queue;
    }

    public String shortnameToUnicode(String str){
        String output = replaceWithFunction(str, SHORTNAME_PATTERN, (shortname) -> {
            if (shortname == null || shortname.isEmpty() || (!shortnameToUnicode.containsKey(shortname))) {
                return shortname;
            }
            if (shortnameToUnicode.get(shortname).isEmpty()) {
                return shortname;
            }
            String unicode = shortnameToUnicode.get(shortname).toUpperCase();
            return convert(unicode);
        });

        return output;
    }
    public String unicodeToShortname(String str){
        String output = replaceWithFunction(str, UNICODE_PATTERN, (unicode) ->{
            if (unicode == null || unicode.isEmpty() || (!unicodeToShortname.containsKey(unicode))) {
                return unicode;
            }
            return unicodeToShortname.get(unicode);
        });
        return output
    }
    private String replaceWithFunction(String input, Pattern pattern, Function<String, String> func) {
        StringBuilder builder = new StringBuilder();
        Matcher matcher = pattern.matcher(input);
        int lastEnd = 0;
        while (matcher.find()) {
            String lastText = input.substring(lastEnd, matcher.start());
            builder.append(lastText);
            builder.append(func.apply(matcher.group()));
            lastEnd = matcher.end();
        }
        builder.append(input.substring(lastEnd));
        return builder.toString();
    }
    private String convert(String unicodeStr) {
        if (unicodeStr.isEmpty())
            return unicodeStr;
        String[] parts = unicodeStr.split("-");
        StringBuilder buff = new StringBuilder();
        for (String s : parts) {
            int part = Integer.parseInt(s, 16);
            if (part >= 0x10000 && part <= 0x10FFFF) {
                int hi = (int) (Math.floor((part - 0x10000) / 0x400) + 0xD800);
                int lo = ((part - 0x10000) % 0x400) + 0xDC00;
                buff.append(new String(Character.toChars(hi)) + new String(Character.toChars(lo)));
            } else {
                buff.append(new String(Character.toChars(part)));
            }
        }
        return buff.toString();
    }
}