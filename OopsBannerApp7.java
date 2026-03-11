public class OOPSBannerApp {

    static class CharacterPatternMap {
        Character character;
        String[] pattern;

        public CharacterPatternMap(Character character, String[] pattern) {
            this.character = character;
            this.pattern = pattern;
        }

        public Character getCharacter() {
            return character;
        }

        public String[] getPattern() {
            return pattern;
        }
    }

    public static CharacterPatternMap[] createCharacterPatternMaps() {

        String[] O = {
                "  OOO  ",
                " O   O ",
                "O     O",
                "O     O",
                "O     O",
                " O   O ",
                "  OOO  "
        };

        String[] P = {
                "PPPPP  ",
                "P    P ",
                "P    P ",
                "PPPPP  ",
                "P      ",
                "P      ",
                "P      "
        };

        String[] S = {
                " SSSSS ",
                "S     S",
                "S      ",
                " SSSSS ",
                "      S",
                "S     S",
                " SSSSS "
        };

        String[] space = {
                "       ",
                "       ",
                "       ",
                "       ",
                "       ",
                "       ",
                "       "
        };

        return new CharacterPatternMap[]{
                new CharacterPatternMap('O', O),
                new CharacterPatternMap('P', P),
                new CharacterPatternMap('S', S),
                new CharacterPatternMap(' ', space)
        };
    }

    public static String[] getCharacterPattern(char ch, CharacterPatternMap[] charMaps) {
        for (CharacterPatternMap map : charMaps) {
            if (map.getCharacter() == ch) {
                return map.getPattern();
            }
        }
        return getCharacterPattern(' ', charMaps);
    }

    public static void printMessage(String message, CharacterPatternMap[] charMaps) {
        int height = 7;

        for (int i = 0; i < height; i++) {
            for (char ch : message.toCharArray()) {
                String[] pattern = getCharacterPattern(ch, charMaps);
                System.out.print(pattern[i] + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CharacterPatternMap[] charMaps = createCharacterPatternMaps();
        String message = "OOPS";
        printMessage(message, charMaps);
    }
}