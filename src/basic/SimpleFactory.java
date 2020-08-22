package basic;

public class SimpleFactory {

    public static API creatApi(int type){
        if (type==1){
            return new APIA();
        }else {
            return new ApiB();
        }
    }

    public static void main(String[] args) {
        API res= creatApi(2);
        res.meth();
    }
}
