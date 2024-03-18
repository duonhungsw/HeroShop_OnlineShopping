
GO
CREATE TABLE [User] (
  [id] INT PRIMARY KEY IDENTITY(1,1),
  [fullname] NVARCHAR(50) NOT NULL,
  [password] VARCHAR(32),
  [email] VARCHAR(150) UNIQUE,
  [phone_number] VARCHAR(20),
  [address] NVARCHAR(200),
  [role] INT,

);

GO

CREATE TABLE [Category] (
  [id] INT PRIMARY KEY IDENTITY(1,1),
  [name] NVARCHAR(100) NOT NULL
);

GO
CREATE TABLE Product (
  [id] int PRIMARY KEY IDENTITY(1,1),
  [Category_id] int,
  [title] nvarchar(350),
  [size] char(1),
  [price] int,
  [description] nvarchar(1000), 
  [thumbnail] nvarchar(500)
);
GO
CREATE TABLE [dbo].[Comment](
	[id] [int] PRIMARY KEY IDENTITY(1,1) NOT NULL,
	[User_id] [int] NULL,
	[content] nvarchar(1000) NULL,
	);
GO

CREATE TABLE [FeedBack] (
  [id] int PRIMARY KEY IDENTITY(1,1),
  [user_id] int,
  [firstname] nvarchar(30) not null,
  [lastname] nvarchar(30) not null,
  [email] varchar(150) unique,
  [phone_number] varchar(20),
  [subject_name] nvarchar(200),
  [note] nvarchar(500)
);
GO

CREATE TABLE [Orders] (
  [id] int PRIMARY KEY IDENTITY(1,1),
  [user_id] int,
  [fullname] nvarchar(50) not null,
  [email] varchar(150) unique,
  [phone_number] varchar(20),
  [address] varchar(200),
  [note] nvarchar(500),
  [status] [int] NULL,
  [total_money] int
);
GO

CREATE TABLE [Order_Details] (
  [id] int PRIMARY KEY IDENTITY(1,1),
  [order_id] int,
  [product_id] int,
  [price] int,
  [num] int,
  [total_money] int,
  [quantity] int
);

Create table OrderStatus(
    [id] [int] PRIMARY KEY IDENTITY(1,1) NOT NULL,
	[name] [varchar](50) NULL,
);
GO

ALTER TABLE [Orders] ADD FOREIGN KEY ([Status]) REFERENCES [OrderStatus] ([id])
GO

ALTER TABLE [Product] ADD FOREIGN KEY ([Category_id]) REFERENCES [Category] ([id])
GO

ALTER TABLE [Order_Details] ADD FOREIGN KEY ([product_id]) REFERENCES [Product] ([id])
GO

ALTER TABLE [Comment] ADD FOREIGN KEY ([User_id]) REFERENCES [User] ([id])
GO

ALTER TABLE [Order_Details] ADD FOREIGN KEY ([order_id]) REFERENCES [Orders] ([id])
GO

ALTER TABLE [Orders] ADD FOREIGN KEY ([user_id]) REFERENCES [User] ([id])
GO

ALTER TABLE [FeedBack] ADD FOREIGN KEY ([user_id]) REFERENCES [User] ([id]) 

GO
ALTER TABLE [User]  WITH CHECK ADD CHECK  (([role]=(1) OR [role]=(0)))

GO
ALTER TABLE [Order_Details]  WITH CHECK ADD CHECK  (([price]>=(0.0)))
GO
ALTER TABLE [Order_Details]  WITH CHECK ADD CHECK  (([quantity]>=(1)))
GO
ALTER TABLE [Product]  WITH CHECK ADD CHECK  (([price]>=(0)))

INSERT INTO Category VALUES ('Áo phông');
INSERT INTO Category VALUES ('Áo khoác');   
INSERT INTO Category VALUES ('Quần thể thao');

INSERT INTO OrderStatus VALUES ('Đang Giao');
INSERT INTO OrderStatus VALUES ('Hoàn Thành');