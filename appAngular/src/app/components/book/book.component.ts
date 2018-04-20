import { Book } from '../../model/book';
import { ApiService } from '../../services/api.service';
import { AppEnums, EnumBookSection } from '../../app.enums';
import { Utils } from '../../utils';
import { Component, OnInit } from '@angular/core';

export enum PageType{
  LIST_BOOKS,
  EDIT_BOOK
}

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {
  pageType = PageType;                        // This exposed the enum to the HTML
  page: PageType = PageType.LIST_BOOKS;       // This is the default view
  
  books: any;
  authors: any;
  book: Book;
  
  bookSectionNames;
  bookSection;
  
  constructor(private _service: ApiService ) { 
    this.bookSectionNames = AppEnums.getBookSectionNames();
    this.bookSection = EnumBookSection;
    
    console.log ( "Constructing with bookSectionNames: " + this.bookSectionNames );
  
  }
  
  getBookSectionKeys(){
    return Array.from(this.bookSectionNames.keys());
  }
    
  editBook(id: number){
    this.book = Utils.getObjectInArray('id', id, this.books);
    if ( !this.book ) this.book = new Book();
    this.page = PageType.EDIT_BOOK; 
  }
  upsertBook(){
    this._service.createBook(this.book).subscribe(
        success => { this._service.readBooks().subscribe( books => this.books = books); }
    );    
    this.page = PageType.LIST_BOOKS;    
  }
  

  ngOnInit() {
    this._service.readBooks().subscribe( books => this.books = books);
    this._service.readAuthors().subscribe( authors => this.authors = authors);
  }

}
