<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
  <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        /*h2 {
            text-align: center;
            color: #333;
        }*/

        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
        }

        label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
        }

        input[type="number"],
        input[type="text"],
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
            font-size: 16px;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        .form-container {
            display: flex;
            flex-direction: column;
            align-items: center;
        }
    </style>
</head>
<body>
<h2>Welcome to Home Page</h2>
<br><br>
<h1>Product||Products</h1>

<form action="HomeServlet" method="post">
		<label>Product Name:</label>
        <input type="text" id="productName" name="productName" required><br><br>
		        
        <label>Price:</label>
        <input type="number" id="price" name="price" required><br><br>

        <label>Category:</label>
        <input type="text" id="category" name="category" required><br><br>

        <label>Quantity:</label>
        <input type="number" id="qty" name="qty" required><br><br>

        <label>Product Image</label>
        <input type="text" name="productImagePath"><br><br>

        <input type="submit" value="Submit">
</form>

</body>
</html>