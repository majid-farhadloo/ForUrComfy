var mongoose = require('mongoose');

var deliveryguySchema = new mongoose.Schema({
  deliveryguy_name: String,
  X_coordinate: Number,
  Y_coordinate: Number
});

var deliveryguy = mongoose.model ('deliveryguy',deliveryguySchema);
module.exports = deliveryguy;
