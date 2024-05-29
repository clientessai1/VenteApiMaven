#!/usr/bin/env bash
echo "Creating users..."
mongo admin --host localhost -u root -p root --eval "db.getSiblingDB('ventedb').createCollection('collection_test');  db.createUser({user: 'administrator', pwd: 'no1willguess', roles: [{role: 'userAdminAnyDatabase', db: 'admin'}]}); db.getSiblingDB('ventedb').createUser({ user: 'ventedba', pwd: 'esgisdba', roles: [{ role: 'readWrite', db: 'ventedb' }] });"

echo "Users created."