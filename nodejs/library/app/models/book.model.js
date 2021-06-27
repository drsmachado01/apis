var mongoose = require("mongoose");
var Schema = mongoose.Schema;

var writerSchema = new Schema({
  id: String,
  name: String,
  nationality: String,
});

writerSchema.method("toJSON", function () {
  const { __v, _id, ...object } = this.toObject();
  object.id = _id;
  return object;
});

var bookSchema = new Schema({
  id: String,
  isbn: String,
  title: String,
  category: String,
  releaseYear: Number,
  language: String,
  totalPages: Number,
  synopsis: String,
  writers: [writerSchema],
});

bookSchema.method("toJSON", function () {
  const { __v, _id, ...object } = this.toObject();
  object.id = _id;
  return object;
});

const Book = mongoose.model("book", bookSchema);
module.exports = Book;
