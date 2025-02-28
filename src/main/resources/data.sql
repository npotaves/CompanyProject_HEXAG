DELETE FROM transaction;
DELETE FROM company;

INSERT INTO company (cuit, company_name, subscription_date) VALUES
('30123456781', 'Empresa Test 1', NOW() - INTERVAL '1 month'),
('30123456782', 'Empresa Test 2', NOW() - INTERVAL '1 month'),
('30123456783', 'Empresa Test 3', NOW() - INTERVAL '1 month'),
('30123456789', 'Empresa Test 4', NOW() - INTERVAL '1 month'),
('30876543210', 'Empresa Test 5', NOW() - INTERVAL '1 month');

INSERT INTO transaction (importe, cuenta_debito, cuenta_credito, transaction_date, id_company) VALUES
(1000.50, '123456', '654321', NOW() - INTERVAL '1 month', 1),
(500.75, '987654', '456789', NOW() - INTERVAL '1 month', 2),
(1000.50, '456456', '67567576', NOW() - INTERVAL '1 month', 3),
(1000.50, '56456', '7867868', NOW() - INTERVAL '1 month', 4),
(1000.50, '45646', '43535', NOW() - INTERVAL '1 month', 5);