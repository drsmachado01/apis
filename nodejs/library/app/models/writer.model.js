var mongoose = require("mongoose");
var Schema = mongoose.Schema;

var writerSchema = new Schema({
  id: Number,
  name: String,
  nationality: String,
});

writerSchema.method("toJSON", function () {
  const { __v, _id, ...object } = this.toObject();
  object.id = _id;
  return object;
});

const Writer = mongoose.model("writer", writerSchema);
module.exports = Writer;
