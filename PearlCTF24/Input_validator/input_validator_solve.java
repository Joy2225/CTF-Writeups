public class input_validator_solve {
    private static final int FLAG_LEN = 34;

    public static void main(String[] args) {
        String var2 = "oF/M5BK_U<rqxCf8zWCPC(RK,/B'v3uARD";
        int[] var3 = new int[]{1102, 1067, 1032, 1562, 1612, 1257, 1562, 1067, 1012, 902, 882, 1397, 1472, 1312, 1442, 1582, 1067, 1263, 1363, 1413, 1379, 1311, 1187, 1285, 1217, 1313, 1297, 1431, 1137, 1273, 1161, 1339, 1267, 1427};

        int[] var6 = new int[34];

        // Reverse the adding of 1337
        for (int i = 0; i < 34; i++) {
            var6[i] = var3[i] - 1337;
        }

        int[] var2Reverse = new int[34];
        for(int i=0;i<17;++i){
            var2Reverse[i*2]=var6[i+17]/2;
            var2Reverse[1+i*2]=var6[i]/5;
        }
        // Reverse the calculation of var2[var4] -= var1.charAt(33 - var4);

        for (int i = 0; i < 34; i++) {
                var2Reverse[i] = var2Reverse[i] + var2.charAt(33 - i);
        }

        // Reverse the calculation of var2[var4] = var0.charAt(var4) ^ var1.charAt(var4);
        int[] var1Reverse = new int[34];
        for (int i = 0; i < 34; i++) {
            var1Reverse[i] = var2Reverse[i] ^ var2.charAt(i);
        }

        // Convert int array back to string
        StringBuilder flag = new StringBuilder();
        for (int i = 0; i < 34; i++) {
            flag.append((char) var1Reverse[i]);
        }
        String ans = flag.toString();
        System.out.println("Flag: " + ans);
    }
}