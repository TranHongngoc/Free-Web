import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {configBook} from '../appplicationConfig/config';

@Injectable()
export class BookService {
  constructor(private http: HttpClient) {
  }

  getBooks(): Observable<any> {
    return this.http.get<any>(configBook.get_book_API);
  }
}
