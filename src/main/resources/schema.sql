-- Create the Organization table
CREATE TABLE Organization (
    id UUID PRIMARY KEY,
    external_id CHAR(36) UNIQUE NOT NULL,
    name VARCHAR(50) NOT NULL,
    industry VARCHAR(50),
    location VARCHAR(50),
    established_date TIMESTAMP
);

-- Create the Emission table
CREATE TABLE Emission (
    id UUID PRIMARY KEY,
    external_id CHAR(36) UNIQUE NOT NULL,
    date TIMESTAMP,
    type VARCHAR(50),
    amount DOUBLE,
    source VARCHAR(50),
    organization_id CHAR(36),
    FOREIGN KEY (organization_id) REFERENCES Organization(id) ON DELETE CASCADE
);

-- Create the ResourceUsage table
CREATE TABLE Resource_Usage (
    id UUID PRIMARY KEY,
    external_id CHAR(36) UNIQUE NOT NULL,
    type VARCHAR(50),
    amount DOUBLE,
    organization_id CHAR(36),
    FOREIGN KEY (organization_id) REFERENCES Organization(id) ON DELETE CASCADE
);

-- Create the RegulatoryCompliance table
CREATE TABLE Regulatory_Compliance (
    id UUID PRIMARY KEY,
    external_id CHAR(36) UNIQUE NOT NULL,
    name VARCHAR(50),
    compliant_status VARCHAR(50),
    organization_id CHAR(36),
    FOREIGN KEY (organization_id) REFERENCES Organization(id) ON DELETE CASCADE
);

-- Create the SustainabilityInitiative table
CREATE TABLE Sustainability_Initiative (
    id UUID PRIMARY KEY,
    external_id CHAR(36) UNIQUE NOT NULL,
    name VARCHAR(50),
    description TEXT,
    impact_measure VARCHAR(255),
    organization_id CHAR(36),
    FOREIGN KEY (organization_id) REFERENCES Organization(id) ON DELETE CASCADE
);

-- Create the USER table
CREATE TABLE USERS (
    id UUID PRIMARY KEY,
    external_id CHAR(36) UNIQUE NOT NULL,
    username VARCHAR(20),
    password VARCHAR(20),
    email VARCHAR(50),
    organization_id CHAR(36),
    FOREIGN KEY (organization_id) REFERENCES Organization(id) ON DELETE CASCADE
);

CREATE TABLE roles (
    id UUID PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE user_roles (
    user_id UUID,
    role_id UUID,
    PRIMARY KEY (user_id, role_id),
    CONSTRAINT fk_user
        FOREIGN KEY (user_id)
        REFERENCES users (id),
    CONSTRAINT fk_role
        FOREIGN KEY (role_id)
        REFERENCES roles (id)
);
