/* ---------------------------------------------------------------------- */
/* Script generated with: DeZign for Databases v6.3.4                     */
/* Target DBMS:           SQLite3                                         */
/* Project file:          myLibrary.dez                                   */
/* Project name:                                                          */
/* Author:                                                                */
/* Script type:           Database creation script                        */
/* Created on:            2018-04-15 08:20                                */
/* ---------------------------------------------------------------------- */


/* ---------------------------------------------------------------------- */
/* Tables                                                                 */
/* ---------------------------------------------------------------------- */

/* ---------------------------------------------------------------------- */
/* Add table "author"                                                     */
/* ---------------------------------------------------------------------- */

CREATE TABLE "author" (
    "authorId" INTEGER,
    "name" TEXT,
    CONSTRAINT "PK_author" PRIMARY KEY ("authorId")
);

/* ---------------------------------------------------------------------- */
/* Add table "tag"                                                        */
/* ---------------------------------------------------------------------- */

CREATE TABLE "tag" (
    "tagId" INTEGER,
    "name" TEXT,
    CONSTRAINT "PK_tag" PRIMARY KEY ("tagId")
);

/* ---------------------------------------------------------------------- */
/* Add table "book"                                                       */
/* ---------------------------------------------------------------------- */

CREATE TABLE "book" (
    "bookId" INTEGER,
    "authorId" INTEGER NOT NULL,
    "title" TEXT,
    "year" INTEGER,
    CONSTRAINT "PK_book" PRIMARY KEY ("bookId"),
    FOREIGN KEY ("authorId") REFERENCES "author" ("authorId")
);

/* ---------------------------------------------------------------------- */
/* Add table "xref_tag_book"                                              */
/* ---------------------------------------------------------------------- */

CREATE TABLE "xref_tag_book" (
    "tagId" INTEGER,
    "bookId" INTEGER,
    FOREIGN KEY ("tagId") REFERENCES "tag" ("tagId"),
    FOREIGN KEY ("bookId") REFERENCES "book" ("bookId")
);

/* ---------------------------------------------------------------------- */
/* Foreign key constraints                                                */
/* ---------------------------------------------------------------------- */
