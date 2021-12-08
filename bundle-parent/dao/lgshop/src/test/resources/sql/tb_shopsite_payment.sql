DROP TABLE IF EXISTS tb_shopsite_payment;

CREATE TABLE tb_shopsite_payment (
  id_shopsite bigint(20) NOT NULL,
  id_payment int(10) NOT NULL AUTO_INCREMENT,
  pay_Amount int(11) NOT NULL,
  pay_MerchantId varchar(15) NOT NULL,
  pay_MerchantLanguage varchar(2) NOT NULL DEFAULT 'fr',
  pay_MerchantCountry varchar(2) NOT NULL DEFAULT 'FR',
  pay_TransactionId varchar(10) NOT NULL,
  pay_PaymentMeans varchar(128) NOT NULL,
  pay_TransmissionDate timestamp NOT NULL,
  pay_PaymentTime timestamp NOT NULL DEFAULT '2009-03-31 22:00:00',
  pay_ResponseCode varchar(2) NOT NULL,
  pay_PaymentCertificate varchar(12) NOT NULL,
  pay_AuthorisationId varchar(10) NOT NULL,
  pay_CurrencyCode int(3) DEFAULT NULL,
  pay_CardNumber varchar(7) NOT NULL,
  pay_CvvFlag int(10) NOT NULL,
  pay_CvvResponseCode varchar(2) NOT NULL,
  pay_BankResponseCode varchar(2) NOT NULL,
  pay_ComplementaryCode varchar(2) NOT NULL,
  pay_ComplementaryInfo varchar(255) NOT NULL,
  pay_ReturnContext varchar(256) NOT NULL,
  pay_Caddie varchar(150) NOT NULL,
  pay_Language varchar(2) NOT NULL,
  pay_CustomerId varchar(19) NOT NULL,
  pay_OrderId varchar(32) NOT NULL,
  pay_CustomerEmail varchar(128) NOT NULL,
  pay_CustomerIpAddress varchar(19) NOT NULL,
  pay_CaptureDay int(2) NOT NULL,
  pay_CaptureMode varchar(20) NOT NULL,
  pay_Data blob NOT NULL,
  PRIMARY KEY (id_payment,id_shopsite)
);

INSERT INTO tb_shopsite_payment values ('30808', '1', '100', '042508587500071', 'fr', 'fr', '164059', 'VISA', '2009-06-18 14:40:59',
'2009-06-18 16:44:43', '00', 'b01308d1ce43', '163549', '978', '4978.58', '1', '??', '00', '', '', '', '', 'fr', '9164059', '', 'cd@cosydeco.com', '', '0', 'VALIDATION', '');

