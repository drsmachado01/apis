const express = require("express");
const cors = require("cors");

const app = express();

var corsOptions = {
  origin: "http://localhost:8081",
};

app.use(cors(corsOptions));

app.use(express.json());

app.use(express.urlencoded({ extended: true }));

const db = require("./app/models");
db.mongoose
  .connect(db.url, {
    useNewUrlParser: true,
    useUnifiedTopology: true,
  })
  .then(() => {
    console.log("Connected to the database");
  })
  .catch((err) => {
    console.log("Cannot connect to the database", err);
    process.exit();
  });

app.get("/", (req, res) => {
  res.json({ message: "Welcome to the library" });
});

require("./app/routes/library.routes.js")(app);

const PORT = process.env.PORT || 9999;
app.listen(PORT, () => {
  console.log(`Library server is running on port ${PORT}`);
});
