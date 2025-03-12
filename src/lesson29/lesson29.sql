create schema library;

create table library.books(
book_id SERIAL primary key,
title VARCHAR(255) not null,
author VARCHAR(255) not null,
published_year INT check (published_year > 0),
genre VARCHAR(100)
);

create table library.readers(
reader_id SERIAL primary key,
name VARCHAR(100) not null,
email VARCHAR (255) unique not null,
phone VARCHAR (15) unique
);

create type book_status as enum ('borrowed', 'returned');

create table library.borrowed_books(
borrow_id SERIAL primary key,
book_id INT not null,
reader_id int not null,
borrow_date date not null,
return_date date not null,
status book_status,

constraint fk_book foreign key (book_id) 
references library.books(book_id) on delete cascade,

constraint fk_reader foreign key (reader_id) 
references library.readers(reader_id) on delete cascade
);

create index idx_book_title 
on library.books(title);

create index idx_borrowed_books_reader
on library.borrowed_books(reader_id) 
where return_date is null;

insert into library.books (title, author, published_year, genre) values
('Pride and Prejudice', 'Jane Austen', 1813, 'Romance'),
('1984', 'George Orwell', 1949, 'Dystopian'),
('Moby-Dick', 'Herman Melville', 1851, 'Adventure'),
('The Great Gatsby', 'F. Scott Fitzgerald', 1925, 'Tragedy'),
('War and Peace', 'Leo Tolstoy', 1869, 'Historical Fiction'),
('Crime and Punishment', 'Fyodor Dostoevsky', 1866, 'Psychological Fiction'),
('One Hundred Years of Solitude', 'Gabriel García Márquez', 1967, 'Magic Realism'),
('To Kill a Mockingbird', 'Harper Lee', 1960, 'Southern Gothic'),
('The Catcher in the Rye', 'J.D. Salinger', 1951, 'Coming-of-age'),
('Don Quixote', 'Miguel de Cervantes', 1605, 'Satire');

select * from library.books;

insert into library.readers (name, email, phone) values
('John Smith', 'john.smith@example.com', '123-456-7890'),
('Emily Johnson', 'emily.johnson@example.com', '987-654-3210'),
('Michael Brown', 'michael.brown@example.com', '555-123-4567'),
('Sophia Martinez', 'sophia.martinez@example.com', '444-789-1234'),
('David Wilson', 'david.wilson@example.com', '333-222-1111');

insert into library.borrowed_books (book_id, reader_id, borrow_date, return_date, status) values
(21, 2, '2024-02-20', '2024-03-05', 'returned'),
(22, 1, '2024-02-25', '2024-03-10', 'returned'),
(23, 3, '2024-03-01', '2024-03-15', 'returned'),
(24, 4, '2024-03-05', '2024-03-20', 'borrowed'),
(25, 5, '2024-03-08', '2024-03-25', 'borrowed'),
(26, 1, '2024-03-10', '2024-03-30', 'borrowed'),
(27, 2, '2024-03-12', '2024-03-27', 'borrowed'),
(28, 3, '2024-03-15', '2024-04-01', 'borrowed'),
(29, 4, '2024-03-18', '2024-04-05', 'borrowed'),
(30, 5, '2024-03-20', '2024-04-10', 'borrowed');













