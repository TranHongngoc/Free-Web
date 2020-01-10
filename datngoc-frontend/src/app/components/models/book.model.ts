export class BookModel {
  id: number;
  name: string;
  author: string;
  type: string;
  year: number;


  constructor(name: string, author: string, type: string, year: number) {
    this.name = name;
    this.author = author;
    this.type = type;
    this.year = year;
  }
}
