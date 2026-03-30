class Solution {
    public int numUniqueEmails(String[] emails) {

        Set<String> set = new HashSet<>(emails.length);
        StringBuilder sb = new StringBuilder();

        for (String email : emails) {
            sb.setLength(0);
            int atIdx = email.indexOf("@");
            char [] chars = email.toCharArray();

            for (int i = 0; i < atIdx; i++) {
                char ch = chars[i];
                if (ch == '.') {
                    continue;
                } else if (ch == '+') {
                    break;
                }
                sb.append(ch);
            }

            sb.append(email, atIdx, email.length());
            set.add(sb.toString());
        }

        return set.size();
    }
}