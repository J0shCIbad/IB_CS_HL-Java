/*
 * review for IB Math
 * 
 * J0SHIFIED
 */

public class MiscMathTopics
{
    /*
     *      Annual Compound Interest,  A = p(1+ r)^numYears
     *      You invest $500 in an account that pays 3% interest compounded annually. Find the balance after 2 years.
     * 
     *    amount = initial investment (p)
     *    numYears = the number of years the money is invested
     *    rate = interest rate paid.  Given as a decimal, that is if rate = .05, the interest is 5%
     * 
     */   
    public static double calculateAnnualCompoundInterest(double amount, int numYears, double rate){
        return amount*Math.pow(1+rate, numYears);
    }

    /*
     * compound interest   // you find the formula
     *      1) You invest $100 in an account that pays 10% interest compounded annually.
     *         Find the balance after 1 year.
     *      2) You invest $100 in an account that pays 10% interest compounded semiannually.
     *         Find the balance after 1 year.
     *
     *    amount = initial investment
     *    num = number of compunding per year.  annuanlly = once a year
     *                                          semiannually = twice a year
     *    numYears = the number of years the money is invested
     *    rate = interest rate paid.  Given as a decimal, that is if rate = .05, the interest is 5%
     *    
     */   
    public static double calculateCompoundInterest(double amount, int num, int numYears, double rate){
        return amount*Math.pow(1+rate/num, num*numYears);
    }

    /*
     *  Applications of exponential and log equations
     *  
     *  The half-life of carbon-11 is 20 minutes.
     *  How much long will it take to 600 g of carbon-11 to decay to 30 g?
     *  
     *  halfLife = half life of given element
     *  iAmount = starting amount of given element
     *  duration = the time spent waiting for the given element
     *  
     *  units will both iAmount and fAmount will always be the same
     *  
     *  the units of the returned value will be asume to be the same as halfLife
     *  
     */   
    public static double calculateHalfLifeAmount(double halfLife, double iAmount, double duration){
        return iAmount*Math.pow(0.5, duration/halfLife);
    }

    /*
     *  Applications of exponential and log equations
     *  
     *  The half-life of carbon-11 is 20 minutes. How long will it take to 600 g of carbon-11 to decay to 30 g?
     *  
     *  halfLife = half life of given element
     *  iAmount = starting amount of given element
     *  fAmount = final amount of given element
     *  
     *  units will both iAmount and fAmount will always be the same
     *  
     *  the units of the returned value will be asume to be the same as halfLife
     *  
     */
    public static double calculateHalfLifeTime(double halfLife, double iAmount, double fAmount){
        return halfLife*Math.log(fAmount/iAmount)/Math.log(0.5);
    }

    /*
     * 
     *
     *    I.  Continuous Compounding 
     *        1) Suppose that $1000 is invested at 7% interest compounded continuously.
     *        How much money would be in the bank after 5 years?
     *
     * 
     *    amount = initial investment
     *    numYears = the number of years the money is invested
     *    rate = interest rate paid.  Given as a decimal, that is if rate = .05, the interest is 5%
     *    
     */
    public static double calculateContinuousCompounding(double amount, int numYears, double rate)
    {
        return amount*Math.exp(rate*numYears);
    }

    /*
     *    II.  Continuous Compounding 
     *         2) How long will it take to double an amount at 7%?}
     * 
     *    rate = interest rate paid.  Given as a decimal, that is if rate = .05, the interest is 5%
     *    
     */
    public static double calculateContinuousCompounding(double rate){

        return Math.log(2)/rate;
    }
}