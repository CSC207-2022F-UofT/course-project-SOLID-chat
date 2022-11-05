public class EmojiOne{
    public Map<String, List<emoji>> getCatgorizedEmojis(){
        Map<String, List<Emoji>> map = new Hashmap<>();
        emojiMap.values().forEach(emojiEntry -> {
            List<Emoji> list = map.computeIfAbsent(emojiEntry.getCategory(), k -> new ArrayList<>());
            list.add(emojiEntry);
        });
        map.values().forEach(list->list.sort(Comarator.comparing(Emoji::getEmojiOrder)));
        return map;
    }
}