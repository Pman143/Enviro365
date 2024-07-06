-- Insert 10 records into the Organization table
INSERT INTO Organization (id, external_id, name, industry, location, established_date) VALUES
(random_uuid(), random_uuid(), 'Eco Solutions', 'Environmental Services', 'San Francisco, CA', '2010-05-14'),
(random_uuid(), random_uuid(), 'Green Tech', 'Technology', 'Austin, TX', '2012-03-22'),
(random_uuid(), random_uuid(), 'Renewable Energy Corp', 'Energy', 'Seattle, WA', '2008-11-01'),
(random_uuid(), random_uuid(), 'Sustainable Innovations', 'Consulting', 'Denver, CO', '2015-07-18'),
(random_uuid(), random_uuid(), 'Clean Earth Industries', 'Manufacturing', 'Portland, OR', '2009-01-30'),
(random_uuid(), random_uuid(), 'Eco-Friendly Products', 'Retail', 'Chicago, IL', '2013-06-25'),
(random_uuid(), random_uuid(), 'Green Energy Solutions', 'Energy', 'New York, NY', '2011-09-14'),
(random_uuid(), random_uuid(), 'Sustainable Agriculture', 'Agriculture', 'Miami, FL', '2017-04-08'),
(random_uuid(), random_uuid(), 'Eco Tech Innovations', 'Technology', 'Boston, MA', '2014-12-12'),
(random_uuid(), random_uuid(), 'Green Building Solutions', 'Construction', 'Los Angeles, CA', '2018-08-29');

-- Insert example records into the Emission table
INSERT INTO Emission (id, external_id, date, type, amount, source, organization_id) VALUES
(random_uuid(), random_uuid(), '2021-05-14', 'CARBON', 123.45, 'FACTORY', (SELECT id FROM Organization WHERE name = 'Eco Solutions')),
(random_uuid(), random_uuid(), '2021-06-22', 'METHANE', 67.89, 'AGRICULTURE', (SELECT id FROM Organization WHERE name = 'Green Tech')),
(random_uuid(), random_uuid(), '2021-07-01', 'NITROUS_OXIDE', 45.67, 'TRANSPORT', (SELECT id FROM Organization WHERE name = 'Renewable Energy Corp')),
(random_uuid(), random_uuid(), '2021-08-18', 'CARBON', 89.01, 'ENERGY_PRODUCTION', (SELECT id FROM Organization WHERE name = 'Sustainable Innovations')),
(random_uuid(), random_uuid(), '2021-09-30', 'METHANE', 78.56, 'WASTE_MANAGEMENT', (SELECT id FROM Organization WHERE name = 'Clean Earth Industries')),
(random_uuid(), random_uuid(), '2021-10-25', 'NITROUS_OXIDE', 34.56, 'INDUSTRIAL_PROCESSES', (SELECT id FROM Organization WHERE name = 'Eco-Friendly Products')),
(random_uuid(), random_uuid(), '2021-11-14', 'CARBON', 98.76, 'CONSTRUCTION', (SELECT id FROM Organization WHERE name = 'Green Energy Solutions')),
(random_uuid(), random_uuid(), '2021-12-08', 'METHANE', 56.78, 'AGRICULTURE', (SELECT id FROM Organization WHERE name = 'Sustainable Agriculture')),
(random_uuid(), random_uuid(), '2022-01-12', 'NITROUS_OXIDE', 45.67, 'TRANSPORT', (SELECT id FROM Organization WHERE name = 'Eco Tech Innovations')),
(random_uuid(), random_uuid(), '2022-02-28', 'CARBON', 76.54, 'ENERGY_PRODUCTION', (SELECT id FROM Organization WHERE name = 'Green Building Solutions'));
