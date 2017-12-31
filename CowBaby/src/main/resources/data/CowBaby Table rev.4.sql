USE CowBaby;

--�U�Ȫ�
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
	ConsumerSegmentation  tinyint,    --���O�̰Ϲj  
);

--������
IF OBJECT_ID('CowBaby..Classfication') IS NOT NULL DROP TABLE Classfication;
CREATE TABLE Classfication (    
    ClassficationID  int IDENTITY primary key, 
	ClassficatoinName  varchar(50), 
	ClassificationDescription  varchar(Max),
	StartStopStatus  bit,
);

--��x��
IF OBJECT_ID('CowBaby..Backstage') IS NOT NULL DROP TABLE Backstage;
CREATE TABLE Backstage (    
    ApplicationID int IDENTITY primary key, 
	CustomerID int,
	ApplicationDate   datetime2(0),
	ApplicationState  tinyint,
	ApplicationDescription  varchar(max),
);

--�T����
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

--Blog ���}����
IF OBJECT_ID('CowBaby..Blog') IS NOT NULL DROP TABLE Blog;
CREATE TABLE Blog (    
    ArticleID int IDENTITY primary key, 
	ArticlePhoto        image,
	BloggerName        varchar(50),
	ArticleHeader      varchar(Max),
	ArticleContent     varchar(Max),
);

--���~Size��
IF OBJECT_ID('CowBaby..ProductSize') IS NOT NULL DROP TABLE ProductSize;
CREATE TABLE ProductSize (    
    ProductSizeID int IDENTITY primary key, 
	ProductID          int,
	ProductSpec        varchar(max),
	SpecStock		   int,
);

--�q���
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
	StoreID					int,           --FK���p�ܽ�a��x�]�m��StoreID
	Status					tinyint,
	PaymentMethod			tinyint,
);

--��a��x�]�m��(��a�}����)
IF OBJECT_ID('CowBaby..SellerBackstageManage') IS NOT NULL DROP TABLE SellerBackstageManage;
CREATE TABLE SellerBackstageManage (    
    StoreID int IDENTITY primary key, 
	StoreName           varchar(50),
	CustomerID          int,
	StoreStatus			bit,
	StorePhone          varchar(20),       --varchar��(20)
	StoreDescription    varchar(Max),
	StoreRating         int,
	StoreBanner         varchar(Max),
	StoreLogo           image,
	TotalPageView		int,
);

--�s�i��
IF OBJECT_ID('CowBaby..Advertisement') IS NOT NULL DROP TABLE Advertisement;
CREATE TABLE Advertisement (    
    AdID int IDENTITY primary key, 
	StoreID          int,
	AdState			    tinyint,
	OrderAdTime			datetime2(0),
	AdFee               int,
	AdPackage           tinyint,             --�令tinyint
	AdPreviewPhoto      image,               --�s�WAdPreviewPhoto �s�i�w���p��
);

--�s�i���Ӫ�
IF OBJECT_ID('CowBaby..AdvertisementDetail') IS NOT NULL DROP TABLE AdvertisementDetail;
CREATE TABLE AdvertisementDetail (    
    AdDetailID int IDENTITY primary key, 
	AdID                int,
	DisplayAdTime       datetime2(0),
	AdPurchasedState    bit,             --type��bit �s�i�ʶR���A
);

--�s���q��
IF OBJECT_ID('CowBaby..PageView') IS NOT NULL DROP TABLE PageView;
CREATE TABLE PageView (    
    PageViewsID int IDENTITY primary key, 
	StoreID             int,
	PageViewsDate       datetime2(0),
	PageViews			int,
);

--�d���Ӹ`�O
IF OBJECT_ID('CowBaby..MessageBoardDetail') IS NOT NULL DROP TABLE MessageBoardDetail;
CREATE TABLE MessageBoardDetail (    
    MessageDetailID int IDENTITY primary key, 
	MessageID             int,
	MessageTime			  datetime2(0),
	MessageContent		  varchar(Max),
	CustomerID			  int,          --����W/type
);

--�q����Ӫ�
IF OBJECT_ID('CowBaby..OrderDetail') IS NOT NULL DROP TABLE OrderDetail;
CREATE TABLE OrderDetail (    
	OrderDetailID int IDENTITY primary key, 
    OrderID				  int, 
	ProductID             int,
	UnitPrice			  int,
	Quantity			  int,
	Title				  varchar(50),         --�s�W�ӫ~�W��
	ProductSpec			  varchar(max),		   --�s�W�ӫ~�W��
);

--���~��
IF OBJECT_ID('CowBaby..Product') IS NOT NULL DROP TABLE Product;
CREATE TABLE Product (    
    ProductID int IDENTITY primary key, 
	StoreID				  int,
	Title			      varchar(Max),
	Summary			      varchar(Max),
	UnitPrice			  int,
	ProductDescription    varchar(Max),
	ProductStatus         bit,              --type��bit
	ClassficationID		  int,
	SuitableAges		  tinyint,			--type��tinyint
	GenderPreference      char(1),
	DisplayTime           datetime2(0),
	ProductImage		  varchar(Max),
);

--�ө�������
IF OBJECT_ID('CowBaby..StoreRating') IS NOT NULL DROP TABLE StoreRating;
CREATE TABLE StoreRating (    
    RatingID int IDENTITY primary key, 
	CustomerID				  int,
	StoreID			          int,
	RatingScore			      int,
	RatingTime			      datetime2(0),
);

--�d���O��
IF OBJECT_ID('CowBaby..MessageBoard') IS NOT NULL DROP TABLE MessageBoard;
CREATE TABLE MessageBoard (    
    MessageID int IDENTITY primary key, 
	StoreID					  int,
	CustomerID			      int,
	ProductID			      int,					 
	MessageTopic		      varchar(max),          --type��varchar(max)
	MessageTime				  datetime2(0),
);

--Top5 ���~��(���a)
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

--�ȪA��
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
ALTER TABLE �ڭnForeign key��Table�W��
ADD FOREIGN KEY (�ڭnForeign key��Table���) REFERENCES �n�s��Primary key Table(Primary key�����W��);
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
ALTER TABLE Order01														--Order01 ��StoreID FK���p�� SellerBackstageManage ��PK StoreID
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
ALTER TABLE MessageBoardDetail											--MessageBoardDetail ��CustomerID FK���p��Customer ��PK CustomerID
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



-- �U�Ȱ����
INSERT INTO Customer VALUES ('��ڪ�', 'MD5', '999@gmail.com', '�x�_���H�q�ϩ����F���T�q333��', '02-2977-7777', '0988-888888', Null, '1999-10-10', 'F', '1', '30000', '1', '2017-10-10', '0', '0', '1' , '0', '0' );
INSERT INTO Customer VALUES ('���M�M', 'MD5', '888@gmail.com', '�x�_���H�q�ϩ�������G�q123��', '02-2977-4523', '0988-881663', Null, '1990-03-11', 'M', '0', '50000', '0', '2017-10-11', '0', '0', '1' , '0', '0' );
INSERT INTO Customer VALUES ('���̮f', 'MD5', '777@gmail.com', '�x�_���j�w�ϴ_���n���@�q333��', '02-2871-6377', '0987-978987', Null, '1980-04-11', 'M', '0', '85000', '1', '2017-10-12', '0', '0', '1' , '0', '0' );
INSERT INTO Customer VALUES ('�i�F��', 'MD5', '666@gmail.com', '�x�_���H�q�ϩ����F���T�q332��', '02-2977-5566', '0978-978987', Null, '1985-07-31', 'M', '0', '22000', '0', '2017-10-13', '0', '0', '1' , '0', '0' );
INSERT INTO Customer VALUES ('����޵', 'MD5', '555@gmail.com', '�s�_���H���Ϥ��s�_���@�q387��', '02-2977-7777', '0965-556556', Null, '1987-09-21', 'F', '1', '45000', '1', '2017-10-20', '0', '0', '2' , '0', '0' );

-- �ө������
INSERT INTO SellerBackstageManage VALUES ('޵޵����', '5', '1', '02-2977-7777', '޵�ܤj!!', '0', NULL, NULL, '0');

-- �ӫ~���������
INSERT INTO Classfication VALUES ('����', '���_�_������', '1')
INSERT INTO Classfication VALUES ('�Ϯ�', '���_�_���Ϯ�', '1')
INSERT INTO Classfication VALUES ('��A', '���_�_����A', '1')
INSERT INTO Classfication VALUES ('�c�l', '���_�_���c�l', '1')
INSERT INTO Classfication VALUES ('��Ϋ~', '���_�_����Ϋ~', '1')

-- �ӫ~�����
INSERT INTO Product VALUES 
(1, 'DinDin�c', '�ڬO�@��DinDin�c��', '10000', '�u�O�@���n�諸�c�c', '1', '4', '1', 'F', '2017-11-10', NULL);
INSERT INTO Product VALUES 
(1, 'DinDin��', '�ڬO�@��DinDin���', '10000', '�u�O�@��n�諸���', '1', '3', '1', 'F', '2017-11-10', NULL);
INSERT INTO Product VALUES 
(1, 'DinDin��', '�ڬO�@��DinDin�ѳ�', '10000', '�u�O�@���n�ݪ��Ѯ�', '1', '2', '1', 'F', '2017-11-10', NULL);

-- �W�氲���
INSERT INTO ProductSize VALUES ('1', '22��', '51');
INSERT INTO ProductSize VALUES ('1', '22��', '43');
INSERT INTO ProductSize VALUES ('1', '22��', '32');