USE CowBaby;

--顧客表
IF OBJECT_ID('CowBaby..Customer') IS NOT NULL DROP TABLE Customer;
CREATE TABLE Customer (    
    CustomerID  int IDENTITY primary key, 
	CustomerName  VARCHAR(50), 
	Password      VARCHAR(50),
    Email         VARCHAR(50) UNIQUE,   
	Address       varchar(100),
	Landline      varchar(20),
	MobilePhone   varchar(20),
	LoginPhoto    image,
	Birthday      date,           --java.sql.Date
	Gender        char(1),
	Marriage      bit,
	Income        int,
	Subscription  bit,
	CreateTime    datetime2(0),
	TotalAmoutOfConsumption int,
	ConsumptionTimes int,
	UserID        tinyint,
	Bonus         int,
	ConsumerSegmentation  tinyint,    --消費者區隔  
);

--分類表
IF OBJECT_ID('CowBaby..Classfication') IS NOT NULL DROP TABLE Classfication;
CREATE TABLE Classfication (    
    ClassficationID  int IDENTITY primary key, 
	ClassficatoinName  varchar(50), 
	ClassificationDescription  varchar(Max),
	StartStopStatus  bit,
);

--後台表
IF OBJECT_ID('CowBaby..Backstage') IS NOT NULL DROP TABLE Backstage;
CREATE TABLE Backstage (    
    ApplicationID int IDENTITY primary key, 
	CustomerID int,
	ApplicationDate   datetime2(0),
	ApplicationState  tinyint,
	ApplicationDescription  varchar(max),
);

--訊息表
IF OBJECT_ID('CowBaby..Message') IS NOT NULL DROP TABLE Message;
CREATE TABLE Message (    
    MsgID int IDENTITY primary key, 
	MsgSenderID     int,
	MsgReceiverID   int,
	MsgTime         datetime2(0),
	ReadStatus      bit,
	MsgContent      varchar(Max),
	MsgResponse     varchar(Max),
	MsgMarker       bit,
);

--Blog 媽咪推薦
IF OBJECT_ID('CowBaby..Blog') IS NOT NULL DROP TABLE Blog;
CREATE TABLE Blog (    
    ArticleID int IDENTITY primary key, 
	ArticlePhoto        image,
	BloggerName        varchar(50),
	ArticleHeader      varchar(Max),
	ArticleContent     varchar(Max),
);

--產品Size表
IF OBJECT_ID('CowBaby..ProductSize') IS NOT NULL DROP TABLE ProductSize;
CREATE TABLE ProductSize (    
    ProductSizeID int IDENTITY primary key, 
	ProductID          int,
	ProductSpec        varchar(max),
	SpecStock		   int,
);

--訂單表
IF OBJECT_ID('CowBaby..Order01') IS NOT NULL DROP TABLE Order01;
CREATE TABLE Order01 (    
    OrderID int IDENTITY primary key, 
	CustomerID			    int,
	OrderDate				datetime2(0),
	AcceptDate				datetime2(0),
	BuyerRequestCancel		datetime2(0),
	ShippedDate				datetime2(0),
	TransactionComplete		datetime2(0),
	OrderCancellation       datetime2(0),
	PickUpStore				varchar(50),
	TotalAmount				int,
	TotalItems				int,
	ReceiverName			varchar(50),
	ReceiverEmail			varchar(50),
	ReceiverPhone			varchar(20),
	Usebonus				int,
	StoreID					int,           --FK關聯至賣家後台設置表StoreID
	Status					tinyint,
	PaymentMethod			tinyint,
);

--賣家後台設置表(賣家開的店)
IF OBJECT_ID('CowBaby..SellerBackstageManage') IS NOT NULL DROP TABLE SellerBackstageManage;
CREATE TABLE SellerBackstageManage (    
    StoreID int IDENTITY primary key, 
	StoreName           varchar(50),
	CustomerID          int,
	StoreStatus			bit,
	StorePhone          varchar(20),       --varchar改(20)
	StoreDescription    varchar(Max),
	StoreRating         int,
	StoreBanner         varchar(Max),
	StoreLogo           image,
	TotalPageView		int,
);

--廣告表
IF OBJECT_ID('CowBaby..Advertisement') IS NOT NULL DROP TABLE Advertisement;
CREATE TABLE Advertisement (    
    AdID int IDENTITY primary key, 
	StoreID          int,
	AdState			    tinyint,
	OrderAdTime			datetime2(0),
	AdFee               int,
	AdPackage           tinyint,             --改成tinyint
	AdPreviewPhoto      image,               --新增AdPreviewPhoto 廣告預覽小圖
);

--廣告明細表
IF OBJECT_ID('CowBaby..AdvertisementDetail') IS NOT NULL DROP TABLE AdvertisementDetail;
CREATE TABLE AdvertisementDetail (    
    AdDetailID int IDENTITY primary key, 
	AdID                int,
	DisplayAdTime       datetime2(0),
	AdPurchasedState    bit,             --type改bit 廣告購買狀態
);

--瀏覽量表
IF OBJECT_ID('CowBaby..PageView') IS NOT NULL DROP TABLE PageView;
CREATE TABLE PageView (    
    PageViewsID int IDENTITY primary key, 
	StoreID             int,
	PageViewsDate       datetime2(0),
	PageViews			int,
);

--留言細節板
IF OBJECT_ID('CowBaby..MessageBoardDetail') IS NOT NULL DROP TABLE MessageBoardDetail;
CREATE TABLE MessageBoardDetail (    
    MessageDetailID int IDENTITY primary key, 
	MessageID             int,
	MessageTime			  datetime2(0),
	MessageContent		  varchar(Max),
	CustomerID			  int,          --改欄名/type
);

--訂單明細表
IF OBJECT_ID('CowBaby..OrderDetail') IS NOT NULL DROP TABLE OrderDetail;
CREATE TABLE OrderDetail (    
	OrderDetailID int IDENTITY primary key, 
    OrderID				  int, 
	ProductID             int,
	UnitPrice			  int,
	Quantity			  int,
	Title				  varchar(50),         --新增商品名稱
	ProductSpec			  varchar(max),		   --新增商品規格
);

--產品表
IF OBJECT_ID('CowBaby..Product') IS NOT NULL DROP TABLE Product;
CREATE TABLE Product (    
    ProductID int IDENTITY primary key, 
	StoreID				  int,
	Title			      varchar(Max),
	Summary			      varchar(Max),
	UnitPrice			  int,
	ProductDescription    varchar(Max),
	ProductStatus         bit,              --type改bit
	ClassficationID		  int,
	SuitableAges		  tinyint,			--type改tinyint
	GenderPreference      char(1),
	DisplayTime           datetime2(0),
	ProductImage		  varchar(Max),
);

--商店評價表
IF OBJECT_ID('CowBaby..StoreRating') IS NOT NULL DROP TABLE StoreRating;
CREATE TABLE StoreRating (    
    RatingID int IDENTITY primary key, 
	CustomerID				  int,
	StoreID			          int,
	RatingScore			      int,
	RatingTime			      datetime2(0),
);

--留言板表
IF OBJECT_ID('CowBaby..MessageBoard') IS NOT NULL DROP TABLE MessageBoard;
CREATE TABLE MessageBoard (    
    MessageID int IDENTITY primary key, 
	StoreID					  int,
	CustomerID			      int,
	ProductID			      int,					 
	MessageTopic		      varchar(max),          --type改varchar(max)
	MessageTime				  datetime2(0),
);

--Top5 產品表(店家)
IF OBJECT_ID('CowBaby..Top5Products') IS NOT NULL DROP TABLE Top5Products;
CREATE TABLE Top5Products (    
    Top5ProductID int IDENTITY primary key, 
	StoreID					  int,
	MonthlyTime			      datetime2(0),
	Top1Product			      int,
	Top2Product		          int,
	Top3Product				  int,
	Top4Product				  int,
	Top5Product				  int,
);

--客服表
IF OBJECT_ID('CowBaby..CustomerService') IS NOT NULL DROP TABLE CustomerService;
CREATE TABLE CustomerService (    
    ReportID int IDENTITY primary key, 
	ProblemTypes			  tinyint,
	CustomerID				  int,
	ProblemDescription		  varchar(max),
	ServiceFeedback			  varchar(max),
	ProcessStatus		      tinyint,
	ReportTime				  datetime2(0),
	ReportiInProcess		  datetime2(0),
	ReportFix				  datetime2(0),
);



/*  
ALTER TABLE 我要Foreign key的Table名稱
ADD FOREIGN KEY (我要Foreign key的Table欄位) REFERENCES 要連的Primary key Table(Primary key的欄位名稱);
*/  

ALTER TABLE Backstage
ADD FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID);

ALTER TABLE Message
ADD FOREIGN KEY (MsgSenderID) REFERENCES Customer(CustomerID);
ALTER TABLE Message
ADD FOREIGN KEY (MsgReceiverID) REFERENCES Customer(CustomerID);

ALTER TABLE ProductSize
ADD FOREIGN KEY (ProductID) REFERENCES Product(ProductID);

ALTER TABLE Order01
ADD FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID);
ALTER TABLE Order01														--Order01 的StoreID FK關聯至 SellerBackstageManage 的PK StoreID
ADD FOREIGN KEY (StoreID) REFERENCES SellerBackstageManage(StoreID);

ALTER TABLE SellerBackstageManage
ADD FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID);

ALTER TABLE Advertisement
ADD FOREIGN KEY (StoreID) REFERENCES SellerBackstageManage(StoreID);

ALTER TABLE AdvertisementDetail
ADD FOREIGN KEY (AdID) REFERENCES Advertisement(AdID);

ALTER TABLE PageView
ADD FOREIGN KEY (StoreID) REFERENCES SellerBackstageManage(StoreID);

ALTER TABLE MessageBoardDetail
ADD FOREIGN KEY (MessageID) REFERENCES MessageBoard(MessageID);
ALTER TABLE MessageBoardDetail											--MessageBoardDetail 的CustomerID FK關聯至Customer 的PK CustomerID
ADD FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID);

ALTER TABLE OrderDetail
ADD FOREIGN KEY (ProductID) REFERENCES Product(ProductID);
ALTER TABLE OrderDetail
ADD FOREIGN KEY (OrderID) REFERENCES Order01(OrderID);

ALTER TABLE Product
ADD FOREIGN KEY (StoreID) REFERENCES SellerBackstageManage(StoreID);
ALTER TABLE Product
ADD FOREIGN KEY (ClassficationID) REFERENCES Classfication(ClassficationID);

ALTER TABLE StoreRating
ADD FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID);
ALTER TABLE StoreRating
ADD FOREIGN KEY (StoreID) REFERENCES SellerBackstageManage(StoreID);

ALTER TABLE MessageBoard
ADD FOREIGN KEY (StoreID) REFERENCES SellerBackstageManage(StoreID);
ALTER TABLE MessageBoard
ADD FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID);
ALTER TABLE MessageBoard
ADD FOREIGN KEY (ProductID) REFERENCES Product(ProductID);

ALTER TABLE Top5Products
ADD FOREIGN KEY (StoreID) REFERENCES SellerBackstageManage(StoreID);
ALTER TABLE Top5Products
ADD FOREIGN KEY (Top1Product) REFERENCES Product(ProductID);
ALTER TABLE Top5Products
ADD FOREIGN KEY (Top2Product) REFERENCES Product(ProductID);
ALTER TABLE Top5Products
ADD FOREIGN KEY (Top3Product) REFERENCES Product(ProductID);
ALTER TABLE Top5Products
ADD FOREIGN KEY (Top4Product) REFERENCES Product(ProductID);
ALTER TABLE Top5Products
ADD FOREIGN KEY (Top5Product) REFERENCES Product(ProductID);

ALTER TABLE CustomerService
ADD FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID);



-- 顧客假資料
INSERT INTO Customer VALUES ('方芳芳', 'MD5', '999@gmail.com', '台北市信義區忠孝東路三段333號', '02-2977-7777', '0988-888888', Null, '1999-10-10', 'F', '1', '30000', '1', '2017-10-10', '0', '0', '1' , '0', '0' );
INSERT INTO Customer VALUES ('葉燁燁', 'MD5', '888@gmail.com', '台北市信義區忠孝西路二段123號', '02-2977-4523', '0988-881663', Null, '1990-03-11', 'M', '0', '50000', '0', '2017-10-11', '0', '0', '1' , '0', '0' );
INSERT INTO Customer VALUES ('陳依宸', 'MD5', '777@gmail.com', '台北市大安區復興南路一段333號', '02-2871-6377', '0987-978987', Null, '1980-04-11', 'M', '0', '85000', '1', '2017-10-12', '0', '0', '1' , '0', '0' );
INSERT INTO Customer VALUES ('張東熙', 'MD5', '666@gmail.com', '台北市信義區忠孝東路三段332號', '02-2977-5566', '0978-978987', Null, '1985-07-31', 'M', '0', '22000', '0', '2017-10-13', '0', '0', '1' , '0', '0' );
INSERT INTO Customer VALUES ('曾汜瑑', 'MD5', '555@gmail.com', '新北市淡水區中山北路一段387號', '02-2977-7777', '0965-556556', Null, '1987-09-21', 'F', '1', '45000', '1', '2017-10-20', '0', '0', '2' , '0', '0' );

-- 商店假資料
INSERT INTO SellerBackstageManage VALUES ('瑑瑑的店', '5', '1', '02-2977-7777', '瑑很大!!', '0', NULL, NULL, '0');

-- 商品分類假資料
INSERT INTO Classfication VALUES ('玩具', '給寶寶的玩具', '1')
INSERT INTO Classfication VALUES ('圖書', '給寶寶的圖書', '1')
INSERT INTO Classfication VALUES ('衣服', '給寶寶的衣服', '1')
INSERT INTO Classfication VALUES ('鞋子', '給寶寶的鞋子', '1')
INSERT INTO Classfication VALUES ('日用品', '給寶寶的日用品', '1')

-- 商品假資料
INSERT INTO Product VALUES 
(1, 'DinDin鞋', '我是一雙DinDin鞋喔', '10000', '真是一雙好穿的鞋鞋', '1', '4', '1', 'F', '2017-11-10', NULL);
INSERT INTO Product VALUES 
(1, 'DinDin衣', '我是一件DinDin衣喔', '10000', '真是一件好穿的衣衣', '1', '3', '1', 'F', '2017-11-10', NULL);
INSERT INTO Product VALUES 
(1, 'DinDin書', '我是一件DinDin書喔', '10000', '真是一本好看的書書', '1', '2', '1', 'F', '2017-11-10', NULL);

-- 規格假資料
INSERT INTO ProductSize VALUES ('1', '22黑', '51');
INSERT INTO ProductSize VALUES ('1', '22白', '43');
INSERT INTO ProductSize VALUES ('1', '22藍', '32');