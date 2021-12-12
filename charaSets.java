public class charaSets {
    public static char[] eng52num10 = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm0123456789".toCharArray();
    public static char[] ascii = " !\"#$%&\\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[]^_`abcdefghijklmnopqrstuvwxyz{|}~".toCharArray();
    public static char[] fingerprint(String x){
        return x.toCharArray();
    }
    public static char[] space = " ".toCharArray();
    public static char[] engFingerprint = ("aaaaaaaabbcccddddeeeeeeeeeeeeeffgghhhhhhiiiiiiijkiiiimmnnnnnnnooooooooppqrrrrrrsssssstttttttttuuuvwwxyyz,./<>?;\'\":[]{}\\|-=_+`~1234567890!@#$%^&*()"+"aaaaaaaabbcccddddeeeeeeeeeeeeeffgghhhhhhiiiiiiijkiiiimmnnnnnnnooooooooppqrrrrrrsssssstttttttttuuuvwwxyyz".toUpperCase()).toCharArray();
}
