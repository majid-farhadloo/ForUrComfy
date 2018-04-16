var mongoose = require('mongoose');

var orderSchema = new mongoose.Schema({
  foodName : String,
  price : Number,
  quantity: Number,
  currentUser: String,
  time : String
});

var order = mongoose.model ('order',orderSchema);
module.exports = order;
