package Tax;
import java.util.Scanner;

public class Mian {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入纳税人状态(单身-0  已婚共缴-1  已婚单缴-2  家庭纳税-3)和收入：");
        int status = input.nextInt();
        double income = input.nextDouble();

        TaxPayer people = new TaxPayer(status,income);

        System.out.println("该纳税人应交税：" + people.getTax() + "美元。");
    }

}

class TaxPayer {
    int filingStatus;
    static double[][] brackets;
    static int[][] money = {
            {27050,45200,22600,36250},
            {65550,109250,54625,93650},
            {136750,166500,83250,151650},
            {297351,297351,148676,297351}
    };
    double taxableIncome;

    public static final int SINGLE_FILER = 0;
    public static final int MARRIED_JOINTLY_OR_QUALIFYING_WIDOW = 1;
    public static final int MARRIED_SEPARATELY = 2;
    public static final int HEAD_OF_HOUSEHOLD = 3;

    public TaxPayer() {
        brackets = new double[4][5];
        for (int i = 0;i < brackets.length;i++) {
            brackets[i][0] = 0.15;
            brackets[i][1] = 0.275;
            brackets[i][2] = 0.305;
            brackets[i][3] = 0.355;
            brackets[i][4] = 0.391;
        }
    }

    public TaxPayer(int filingStatus,double taxableIncome) {
        this.filingStatus = filingStatus;
        this.taxableIncome = taxableIncome;

        brackets = new double[4][5];
        for (int i = 0;i < brackets.length;i++) {
            brackets[i][0] = 0.15;
            brackets[i][1] = 0.275;
            brackets[i][2] = 0.305;
            brackets[i][3] = 0.355;
            brackets[i][4] = 0.391;
        }
    }

    public int getFilingStatus() {
        return filingStatus;
    }

    public void setFilingStatus(int filingStatus) {
        this.filingStatus = filingStatus;
    }

    public double getTaxableIncome() {
        return taxableIncome;
    }

    public void setTaxableIncome(double taxableIncome) {
        this.taxableIncome = taxableIncome;
    }

    public double getTax() {
        double tax = 0;

        for(int i = 0;i < 4;i++) {
            if(taxableIncome <= money[i][filingStatus]) {
                tax = taxableIncome * brackets[filingStatus][i];
            }
            tax = taxableIncome * brackets[filingStatus][i];
        }
        return tax;
    }
}