var express = require('express');
var path = require('path');
var favicon = require('serve-favicon');
var logger = require('morgan');
var cookieParser = require('cookie-parser');
var bodyParser = require('body-parser');
var mongoose = require('mongoose');

//var index = require('./routes/index');
//var users = require('./routes/users');

var app = express();

mongoose.connect("mongodb://heroku_vtkwsl62:1234qwer@ds235778.mlab.com:35778/heroku_vtkwsl61");
var db = mongoose.connection;
db.once("open",function() {
	console.log("DB connected!");
});
db.on("error", function (err) {
	console.log("DB ERROR :", err);
});


// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'jade');

app.use(logger('dev'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));

// load router module
var users = require('./routes/users');

//app.use('/', index);
app.use('/users', users);

// catch 404 and forward to error handler
app.use(function(req, res, next) {
  res.status(404).json({"result": false, "message": "Page not found"});
});

// error handler
app.use(function(err, req, res, next) {
  // set locals, only providing error in development
  res.status(err.status || 500).json({"result": false, "message":err});
});

module.exports = app;
