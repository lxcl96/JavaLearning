package chapterFormer;

public class ArithneticOperatorExercise01 {
    public static void main(String[] args) {
        int i = 1, j = 1;
        i = i++;//先temp=i,然后i=i+1;然后i=temp 输出为1
        System.out.println(i);

        j = ++j;//先j=j+1,然后temp=j,然后j=temp 输出2
        System.out.println(j);
    }
}
