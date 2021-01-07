import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public final class Book implements Comparable, Serializable
{
  private String title;
  private String author;
  private float price;
  private Date publicationYear;

  public Book (String title, String author, float price, Date publicationYear)
  {
    this.title = title;
    this.author = author;
    this.price = price;
    this.publicationYear = publicationYear;

  }

  public String getAuthor ()
  {
    return author;
  }
  
  public String getTitle ()
  {
    return title;
  }

  public float getPrice ()
  {
    return price;
  }

  public Date getPublicationYear ()
  {
    return publicationYear;
  }

  public boolean equals (Book book)
  {
    return (this == book);
  }

  public Book clone (Book book)
  {
    return new Book (book.title, book.author, book.price, book.publicationYear);
  }

  @Override
  public int hashCode ()
  {
    LocalDate localDate = publicationYear.toInstant ().atZone (ZoneId.systemDefault ()).toLocalDate ();

    return (int) price * localDate.getYear ();
  }

  @Override
  public String toString ()
  {
    return title + " " + author + " " + price + " " + publicationYear;
  }

  @Override
  public int compareTo (Object o)
  {
    Book book = (Book) o;

    if (book.equals (this)) { return 1; }
    return 0;
  }
}
