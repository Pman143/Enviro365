-- Create the Organization table
CREATE TABLE Organization (
    id UUID PRIMARY KEY,
    external_id CHAR(36) UNIQUE NOT NULL,
    name VARCHAR(255) NOT NULL,
    industry VARCHAR(255),
    location VARCHAR(255),
    established_date TIMESTAMP
);

-- Create the Emission table
CREATE TABLE Emission (
    id UUID PRIMARY KEY,
    external_id CHAR(36) UNIQUE NOT NULL,
    date TIMESTAMP,
    type VARCHAR(255),
    amount DOUBLE,
    source VARCHAR(255),
    organization_id CHAR(36),
    FOREIGN KEY (organization_id) REFERENCES Organization(id) ON DELETE CASCADE
);

-- Create the ResourceUsage table
CREATE TABLE Resource_Usage (
    id UUID PRIMARY KEY,
    external_id CHAR(36) UNIQUE NOT NULL,
    type VARCHAR(255),
    amount DOUBLE,
    organization_id CHAR(36),
    FOREIGN KEY (organization_id) REFERENCES Organization(id) ON DELETE CASCADE
);

-- Create the RegulatoryCompliance table
CREATE TABLE Regulatory_Compliance (
    id UUID PRIMARY KEY,
    external_id CHAR(36) UNIQUE NOT NULL,
    name VARCHAR(255),
    compliant_status VARCHAR(255),
    organization_id CHAR(36),
    FOREIGN KEY (organization_id) REFERENCES Organization(id) ON DELETE CASCADE
);

-- Create the SustainabilityInitiative table
CREATE TABLE Sustainability_Initiative (
    id UUID PRIMARY KEY,
    external_id CHAR(36) UNIQUE NOT NULL,
    name VARCHAR(255),
    description TEXT,
    impact_measure VARCHAR(255),
    organization_id CHAR(36),
    FOREIGN KEY (organization_id) REFERENCES Organization(id) ON DELETE CASCADE
);
