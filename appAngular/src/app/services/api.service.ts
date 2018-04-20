import { Book } from '../model/book';
import { HttpHeaders } from '@angular/common/http';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

const _service = 'http://localhost:8080/myLibrary/rest/';

const _myHeaders = new HttpHeaders()
//                      . set('Authorization', 'Bearer ' + jwt )
                        . set('Content-Type', 'application/json' );


@Injectable()
export class ApiService {

  constructor(private http: HttpClient) { }
  
  readAuthors() {
    return this.http.get<Array<string>>(_service + 'authors');
  }
  readBooks() {
    return this.http.get<Array<string>>(_service + 'books');
  }
  
  createBook(book: Book) {
    return this.http.post<Array<string>>(_service + 'books', JSON.stringify(book), {headers: _myHeaders} );
  }
  
  
  handleError(error: any){
    console.log("Got API error status: " + error.status);
    // Do something like this.router.navigate(['/error']);
  }

}
