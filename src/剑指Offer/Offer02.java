package 剑指Offer;
/*
    请实现一个函数，将一个字符串中的每个空格替换成“%20”。
    例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Offer02 {

    public String replaceSpace(StringBuffer str) {
        String str1=str.toString();
        if(str1.equals("")){
            return  str1;
        }
        char[] charArray = str1.toCharArray();
        int spaceLength = 0;
        for (int i=0;i<charArray.length;i++){
            if (charArray[i]==' ')
                spaceLength++;
        }
        int newLength=str1.length()+spaceLength*2;
        char[] resultArray=new char[newLength];
        int i=str1.length()-1,j=newLength-1;
        while(i>=0){
            if(charArray[i]!=' '){
                resultArray[j--]=charArray[i--];
            }else{
                resultArray[j--]='0';resultArray[j--]='2';resultArray[j--]='%';
                i--;
            }
        }
        return new String(resultArray);
    }

}



/*
一个空格变成了%20，也就是说每有一个空格，长度要增加2，所以首先先计算有多少个空格，
这样长度就能增加多少，得到增加后的长度Length。
然后new一个Length长度的字符数组，从尾到头开始复制原来的数组，复制过程中，
如果字符不是空格，直接复制，如果字符是空格，那么需要把这个空格变成%20
（这个复制过程就是把新建的数组比如现在到了 K这个位置，然后就是K，K-1，K-2这三个位置依次变成0,2，%这三个字符，因为是从后往前复制的所以是倒序），重复这个过程就行。
如果相等，返回true;
 */
