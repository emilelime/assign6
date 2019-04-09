import java.util.Random; //used in pluck()
/**
 * GuitarString models a vibrating guitar string of a given frequency.
 *
 * @author Shirley Lei, Emily Yin
 * @version April 8th, 2019
 */
public class GuitarString<T>{
    private double frequency;
    private BoundedQueue<Double> bq;

    /**
     * The constructor creates a model of guitar string at rest of the given frequency, 
     * using a sampling rate of 44,100
     * @param frequency the fundamental frequency of vibration
     */
    public GuitarString(double frequency){
        this.frequency = frequency;
        //initializes a bounded queue of the desired capacity N, 
        //where N by definition is (int) Math.ceil(44100.0/frequency)
        // ? how to prevent user from putting frequency = 0 (which would be infinity)?
        bq = new BoundedQueue<Double>((int) Math.ceil(44100.0/frequency));
        //fills the bounded queue with N zeros to model a guitar string at rest
        while (!bq.isFull()) {// ?checks twice if bq is full (another time inside enqueue()?)
            bq.enqueue(0.0);
        }

    }

    /**
     * Replaces the N samples in the bounded queue with N random 
     * values between -0.5 and +0.5.
     */
    public void pluck(){
        Random rand = new Random();
        for (int i=0; i<bq.size(); i++) { 
            bq.dequeue();
            double randomVal = (rand.nextDouble()-0.5);
            // Enqueue a double between -0.5 and +0.5
            bq.enqueue(randomVal);
        } 
    }

    /**
     * Returns the value of the item at the front of the bounded queue
     * @return double the value of the item at the front of the bounded queue
     */
    public double sample(){
        return bq.first();
    }

    /**
     * Applies the Karplus-Strong algorithm: deletes the 
     * sample at the front of the bounded queue and adds to the end of the bounded 
     * queue the average of the deleted sample and the sample at the front of the 
     * bounded queue, multiplied by the energy decay factor of 0.994.
     * 
     * //? should these implementation-type comments be included in doc? if not 
     * what doc do i write here
     */
    public void tic(){
        double firstSample = bq.first();
        double average = (firstSample/bq.dequeue())*0.994;
        bq.enqueue(average);
    }

    /**
     * Provides a string representation of a GuitarString
     * @return string representation of a GuitarString
     */
    public String toString() {
        String s = "";
        s+= bq;
        return s;
    }

    /**
     * Trivial (preliminary) testing for GuitarString methods
     * @param args an array string (unused in this case)
     */
    public static void main (String[] args) { //? why running on infinit loop?
        //Tests toString()------------------------------------------------------------------------
        GuitarString<Double> gs = new GuitarString<Double>(0.5);
        System.out.println("gs\n" + gs);
        
        /*
        //Tests on frequency = 0, expect error since divide by infinity:------------------------------------------------------------------------
        GuitarString<Double> gs0 = new GuitarString<Double>(0.0);
        System.out.println("gs0\n" + gs0);
        //test tic(), expect error
        gs0.tic();
        System.out.println("expect error: " + gs0);
        //test sample(), expect error
        gs0.sample();
        System.out.println("expect error: " + gs0);
        //test pluck(), expect error
        gs0.pluck();
        System.out.println("expect error: " + gs0);

        //Tests on regular Guitar String:------------------------------------------------------------------------
        GuitarString<Double> gs1 = new GuitarString<Double>(1.5);
        System.out.println("gs1\n" + gs1);
        gs1.tic();
        System.out.println("expect _____: " + gs1);
        gs1.sample();
        System.out.println("expect _____: " + gs1);
        gs1.pluck();
        System.out.println("expect _____: " + gs1);
        */
    }
}
