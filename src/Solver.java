import java.util.ArrayList;

public class Solver {

    private ArrayList<Integer> numberChain = new ArrayList<Integer>();
    int approximation=6;


    Solver(int x,int y)
    {
        numberChain = chain(x,y);
    }


    Solver(double x)
    {
        numberChain = chain(x);
    }


    public ArrayList<Integer> getNumberChain() {
        return numberChain;
    }


    private ArrayList<Integer> chain(int x, int y)//x=licznik; y =mianownik
    {//creates array of integer values
        ArrayList<Integer> localChain = new ArrayList<Integer>();
        int element;


        for(int i=0;i<this.approximation;i++) {
            element = x / y;
            localChain.add(element);
            x -= element * y;//redukuje x

            if(x==0)
                break;

            element = y;
            y = x;
            x = element;
        }

        return localChain;

    }


    private ArrayList<Integer> chain(double x) {

        double var = 1.0;


        while((x*var)%1.0!=0.0)
        {
            var*=10.0;
        }

        return chain((int)(x*var),(int)var);

    }




    public double putChainTogether()
    {//revert the process made to extract array of numbs

        double element=0;

        if(numberChain.size()==1)
            return numberChain.get(0);

        element=numberChain.get(numberChain.size()-1);



        for(int i=numberChain.size()-2;i>-1;i--)
        {
            element = (1.0/element) + numberChain.get(i);

        }

        return element;


    }


    public String toString()
    {

        String xyz ="";

        for(Integer x: numberChain)
        {
            xyz+=x+", ";
        }

        return xyz;
    }





    public int compare(ArrayList<Integer> xyz)
    {//compares tow chains got from extracting process

        int var=0;

        if(xyz.size()>=numberChain.size())
        {

            for(Integer x:xyz)
            {
                if(x>numberChain.get(var))
                    return -1;
                else if(x<numberChain.get(0))
                    return 1;

                var++;
            }

            if(xyz.size()!=numberChain.size())
                return -1;
            else return 0;


        }else{


            for(Integer x:numberChain)
            {
                if(x>xyz.get(var))
                    return 1;
                else if(x<xyz.get(0))
                    return -1;

                var++;
            }

            if(xyz.size()!=numberChain.size())
                return 1;
            else return 0;



        }





    }




}
