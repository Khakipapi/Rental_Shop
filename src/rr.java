import java.util.Calendar;

/*  * abstract class to represent a generic media  */
abstract class Media2 {
    // attributes
    private int id;
    private String title;
    private int year;

    // validate that 4 digits
    // constructor
    public Media2(int id, String title, int year) {
        this.id = id;   this.title = title;   this.year = year;
    }   // get methods
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public int getYear() {
        return year;
    }
    // set methods
    public void setTitle(String title) {
        this.title = title;
    }
    public void setYear(int year) {
        this.year = year;
    }
    // calculate rental fee; for generic media it is flat fee $3.50
    public double calculateRentalFee() {
        return 3.50;
    }
}

class EBook2 extends Media2 {
    // local attributes
    private int numChapters;
    // constructor
    public EBook2(int id, String title, int year, int chapters) {
        super(id, title, year);
        numChapters = chapters;
    }   // get method
    public int getNumChapters() {
        return numChapters;
    }
    //set method
    public void setNumChapters(int numChapters) {
        this.numChapters = numChapters;
    }    // override parent's
    @Override
    public double calculateRentalFee()
    {
        double fee = numChapters * 0.10;
        // basic fee
        int currYear = Calendar.getInstance().get(Calendar.YEAR);

        if (this.getYear() == currYear)
            fee += 1;  // add $1.00 fee
        return fee;
    }   @Override
    public String toString() {
        return "EBook [ id=" + getId() + ", title=" + getTitle()
                + ", year=" + getYear() + ", chapters=" + numChapters +
                "]";
    }
}
class MovieDVD2 extends Media2 {
    // local attributes
    private double size;
    // value in MB
    // constructor
    public MovieDVD2(int id, String title, int year, double size) {
        super(id, title, year);   this.size = size;
    }   // get method
    public double getSize() {
        return size;
    }   // set method
    public void setSize(double size) {
        this.size = size;
    }
    // inherits calculate rental fee method and no different calculation so should not override
    @Override
    public String toString() {
        return "MovieDVD [ id=" + getId() + ", title=" + getTitle() + ", year="     + getYear()
                + ", size=" + size + "MB]";  } }



class MusicCD2 extends Media2 {
    // local attributes
    private int length;
    //constructor
    public MusicCD2(int id, String title, int year, int length) {
        super(id, title, year);
        this.length = length;
    }    //get method
    public int getLength() {
        return length;
    }   // set method
    public void setLength(int length) {
        this.length = length;
    }    // override parent's
    @Override
    public double calculateRentalFee() {
        double fee = length * 0.02;// basic fee
        int currYear = Calendar.getInstance().get(Calendar.YEAR);
        if (this.getYear() == currYear)
            fee += 1;  // add $1.00 fee
        return fee;
    }   @Override
    public String toString() {
        return "MusicCD [id=" + getId() + ", title=" + getTitle() + ", year="
                + getYear() + ", length=" + length + "min]";  }
}

class RunRental2 {
    public static void main(String[] args) {      // create instances of the ebook and display
        EBook2 ebook = new EBook2(123, "Forever Young", 2018, 20);
        System.out.print(ebook.toString());
        System.out.printf("   Rental fee=$%.2f\n", ebook.calculateRentalFee());
        // create instances of the music cd and display
        MusicCD2 cd = new MusicCD2(124, "Beyond Today", 2020, 114);
        System.out.print(cd.toString());
        System.out.printf("   Rental fee=$%.2f\n" ,
                cd.calculateRentalFee());      // create instances of the movie dvd and display
        MovieDVD2 dvd = new MovieDVD2(125, "After Tomorrow", 2020, 120);
        System.out.print(dvd.toString());
        System.out.printf("   Rental fee=$%.2f\n" ,dvd.calculateRentalFee());
        ebook.setNumChapters(25);
        System.out.print("\nChanging EBook chapters to 25:      ");
        System.out.println(ebook.toString());
        System.out.printf("    New Rental fee=$%.2f\n", ebook.calculateRentalFee());
        cd.setLength(120);
        System.out.print("\nChanging MusicCD length to 120:     ");
        System.out.println(cd.toString());
        System.out.printf("    New Rental fee=$%.2f\n", cd.calculateRentalFee());  }  }
