/* ---------------------------------------------------------------------- */
/* Script generated with: DeZign for Databases v6.3.4                     */
/* Target DBMS:           SQLite3                                         */
/* Project file:          myLibrary.dez                                   */
/* Project name:                                                          */
/* Author:                                                                */
/* Script type:           Database drop script                            */
/* Created on:            2018-04-15 08:20                                */
/* ---------------------------------------------------------------------- */


/* ---------------------------------------------------------------------- */
/* Drop foreign key constraints                                           */
/* ---------------------------------------------------------------------- */

/* ---------------------------------------------------------------------- */
/* Drop table "xref_tag_book"                                             */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

/* Drop table */

DROP TABLE "xref_tag_book";

/* ---------------------------------------------------------------------- */
/* Drop table "book"                                                      */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE "book" DROP CONSTRAINT "NN_book_authorId";

ALTER TABLE "book" DROP CONSTRAINT "PK_book";

/* Drop table */

DROP TABLE "book";

/* ---------------------------------------------------------------------- */
/* Drop table "tag"                                                       */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE "tag" DROP CONSTRAINT "PK_tag";

/* Drop table */

DROP TABLE "tag";

/* ---------------------------------------------------------------------- */
/* Drop table "author"                                                    */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE "author" DROP CONSTRAINT "PK_author";

/* Drop table */

DROP TABLE "author";
