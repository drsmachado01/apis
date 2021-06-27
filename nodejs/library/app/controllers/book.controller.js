const db = require("../models");
const Book = db.books;

exports.create = (req, res) => {
  const receivedBook = req.body;
  const book = createBook(receivedBook);
  book
    .save(book)
    .then((data) => {
      res.send(data);
    })
    .catch((err) => {
      res.status(500).send({
        message: err.message || "Some error occurred while adding the Book.",
      });
    });
};

exports.findAll = (req, res) => {
  Book.find()
    .then((data) => {
      res.send(data);
    })
    .catch((err) => {
      res.status(500).send({
        message: err.message || "Some error occurred while adding the Book.",
      });
    });
};

exports.findOne = (req, res) => {
  const theTitle = req.params.title;
  var condition = theTitle ? { title: theTitle } : {};
  Book.find(condition)
    .then((data) => {
      res.send(data);
    })
    .catch((err) => {
      res.status(500).send({
        message: err.message || "Some error occurred while adding the Book.",
      });
    });
};

exports.update = (req, res) => {
  const id = req.params.id;
  Book.findByIdAndUpdate(id, req.body, { useFindAndModify: false })
    .then((data) => {
      if (!data) {
        res.status(404).send({
          message: `Can't update Book with id ${id}. Maybe it does not exist.`,
        });
      }
      res.send(data);
    })
    .catch((err) => {
      res.status(500).send({
        message: err.message || "Some error occurred while adding the Book.",
      });
    });
};

const createBook = (params) => {
  const receivedWriters = params.writers;

  const theWriters = [];
  for (let i = 0; i < receivedWriters.length; i++) {
    let _writer = {
      name: receivedWriters[i].name,
      nationality: receivedWriters[i].nationality,
    };
    theWriters.push(_writer);
  }

  const book = new Book({
    title: params.title,
    isbn: params.isbn,
    category: params.category,
    releaseYear: params.releaseYear,
    language: params.language,
    totalPages: params.totalPages,
    synopsis: params.synopsis,
    writers: theWriters,
  });

  return book;
};

exports.delete = (req, res) => {
  const id = req.params.id;

  Book.findByIdAndRemove(id)
    .then((data) => {
      if (!data) {
        res.status(404).send({
          message: `Cannot delete book with id=${id}. Maybe this book was not found!`,
        });
      } else {
        res.send({
          message: "The book was deleted successfully!",
        });
      }
    })
    .catch((err) => {
      res.status(500).send({
        message: err.message || "Some error occurred while adding the Book.",
      });
    });
};
