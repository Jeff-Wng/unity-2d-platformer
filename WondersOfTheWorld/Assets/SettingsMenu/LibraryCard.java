class LibraryCard
{
   //Data Members
   private int mID;
   private String mCardHolderName;
   //List to maintain collection of book copies borrowed by this library card
   private ArrayList<BookCopy> mBookCopyList = new ArrayList<>();
  
   //Constructor
   public LibraryCard(int id, String cardHolderName, BookCopy bookCopy)
   {
       mID = id;
       mCardHolderName = cardHolderName;
       mBookCopyList.add(bookCopy);
   }
  
   //Getters and Setters
   //We dont need setter for id as it wont change once set
   public int getId()
   {
       return mID;
   }
  
   public String getCardHolderName()
   {
       return mCardHolderName;
   }
  
  
   public void setCardHolderName(String cardHolderName)
   {
       mCardHolderName = cardHolderName;
   }
  
   //Methods to Add and remove bookcopies to LibraryCard
   public void addBookCopy(BookCopy bookCopy)
   {
       mBookCopyList.add(bookCopy);
       //Adding libraryCard to bookcopy
       bookCopy.setLibraryCard(this);
      
       //Printing on screen that the book has been checked out
       System.out.println("CheckOut Information: ");
       System.out.println("Borrower Name: "+this.mCardHolderName);
       System.out.println("Book Title: "+bookCopy.getBook().getTitle());
       System.out.println("Author Name: "+bookCopy.getBook().getAuthor());
       System.out.println("ISBN No.: "+bookCopy.getBook().getIsbn());
   }
  
   //Method returns true if bookCopy was successfully removed from LibraryCard
   public boolean removeBookCopy(BookCopy bookCopy)
   {
       if(mBookCopyList.contains(bookCopy))
       {
           mBookCopyList.remove(bookCopy);
           //resetting librarycard to null as its checked in now
           bookCopy.setLibraryCard(null);
           System.out.println("Book Checkd In Successfully:");
           System.out.println("Book Title: "+bookCopy.getBook().getTitle());
           return true;
       }
      
       System.out.println("This book is not borrowed by "+this.mCardHolderName);
       return false;
   }
}