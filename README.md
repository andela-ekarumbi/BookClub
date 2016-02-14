# BookClub

### Introduction
BookClub is a collection of classes that implement the logic for the day-to-day activities of a book club.

### Usage
#### 1. Register a new member
```java
package com.andela.bookclub;

import com.andela.bookclub.models.StudentMember;
import com.andela.bookclub.models.StaffMember;
import com.andela.bookclub.operations.Librarian;

public class BookClubTest {
    public static void main(String[] args) {
        // Define member to be registered

        StudentMember studentJohn = new StudentMember();
        studentJohn.setId("234765");
        studentJohn.setSurname("Doe");
        studentJohn.setAge(20);
        studentJohn.setSchool("School of hard knocks");
        // Other setters

        // Initialize library members collection

        LibraryMembers members = new LibraryMembers();

        // Register the new member
        
        members.addNewMember(studentJohn);
    }
}


```

#### 2. Register new book

```java
package com.andela.bookclub;

import com.andela.bookclub.models.Book;
import com.andela.bookclub.models.StaffMember;
import com.andela.bookclub.operations.Librarian;

public class BookClubTest {
    public static void main(String[] args) {
        // Define book to be registered

        Book treasureIsland = new Book();
        treasureIsland.setTitle("Treasure Island");
        treasureIsland.setIsbn("123456");
        treasureIsland.setAuthorName("R.L. Stevenson");
        // Other setters

        // Define staff member on duty, who will be the librarian

        StaffMember staffOnDuty = new StaffMember();
        staffOnDuty.setSurname("Smith");
        // Other setters

        // Initialize librarian with staff member on duty

        Librarian librarian = new Librarian(staffOnDuty);

        // Use the librarian to register the new book

        librarian.registerNewBook(treasureIsland);
    }
}


```

#### 3. Request for a book

```
package com.andela.bookclub.models;

import com.andela.bookclub.models.Book;
import com.andela.bookclub.models.BookRequest;
import com.andela.bookclub.models.Member;
import com.andela.bookclub.models.StaffMember;
import com.andela.bookclub.operations.Librarian;
import com.andela.bookclub.operations.LibraryMembers;
import com.andela.bookclub.operations.LibraryCatalogue;

public class BookClubTest {
    public static void main(String[] args) {
        // Get book to be borrowed

        LibraryCatalogue catalogue = new LibraryCatalogue();

        Book treasureIsland = catalogue.getBookByIsbn("123456");

        // Get member to borrow the book

        Member studentJohn = (new LibraryMembers()).getMemberById("234765");

        // Create a new book request

        BookRequest request = new BookRequest();
        request.setBorrower(studentJohn);
        request.setRequestedBook(treasureIsland);
        // Other setters
        
        // Define staff member on duty, who will be the librarian

        StaffMember staffOnDuty = new StaffMember();
        staffOnDuty.setSurname("Smith");
        // Other setters

        // Initialize librarian with staff member on duty

        Librarian librarian = new Librarian(staffOnDuty);

        // Use the librarian to add the book request

        librarian.addBookRequest(request);
    }
}


```