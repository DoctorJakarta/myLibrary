import { Author } from './author';
import { Tag } from './tag';

export class Book {
  public id: number;
  public title: string;
  public author: Author;
  public tags: Tag[];
}