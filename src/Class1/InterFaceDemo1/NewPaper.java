package Class1.InterFaceDemo1;

public class NewPaper implements IReadable{

    @Override
    public String getContent(){
        return "this is a NewsPaper";
    }

    public String getAd(){
        return "NewsPaper Ad";
    }
}
