module.exports = (app) => {
  const library = require("../controllers/book.controller.js");

  var router = require("express").Router();

  router.post("/", library.create);

  router.get("/", library.findAll);

  router.get("/:title", library.findOne);

  router.put("/:id", library.update);

  router.delete("/:id", library.delete);

  app.use("/library", router);
};
