import {Component, OnInit} from '@angular/core';
import {BookService} from '../../components/services/book.service';
import {BookModel} from '../../components/models/book.model';
import {FormBuilder, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.scss']
})
export class BookComponent implements OnInit {

  constructor(private bookService: BookService,
              private fb: FormBuilder) {
    this.createForm();
  }

  bookForm: FormGroup;
  books;
  bookName;
  bookType = 'book type';
  ngOnInit() {
    this.getBooks();
    this.bookForm.controls.bookName.setValue('nnnn');
  }

  getBooks() {
    this.bookService.getBooks().subscribe(
      data => {
        this.books = data.data;
        console.log(this.books);
      }
    );
  }

  getValue() {
    const bookModel: BookModel = new BookModel(this.bookForm.controls.bookName.value,
      this.bookForm.controls.author.value, this.bookType,  333);
    console.log(bookModel);
  }

  createForm() {
    this.bookForm = this.fb.group({
      bookName: null,
      author: null
    });
  }
}
