##!/bin/bash
#export PGPASSWORD='postgres1'
#BASEDIR=$(dirname $0)
#DATABASE=pokemon_db
#psql -U postgres -f "$BASEDIR/dropdb.sql" &&
#createdb -U postgres $DATABASE &&
#psql -U postgres -d $DATABASE -f "$BASEDIR/schema.sql" &&
#psql -U postgres -d $DATABASE -f "$BASEDIR/data.sql" &&
#psql -U postgres -d $DATABASE -f "$BASEDIR/user.sql"

export PGPASSWORD='Cga3g*BGCBeaGgECCEDb2FEE145F2gcg'
BASEDIR=$(dirname $0)
psql -h monorail.proxy.rlwy.net -U postgres -p 59997 -d railway -f "$BASEDIR/dropdb.sql" &&
psql -h monorail.proxy.rlwy.net -U postgres -p 59997 -d railway -f "$BASEDIR/schema.sql" &&
psql -h monorail.proxy.rlwy.net -U postgres -p 59997 -d railway -f "$BASEDIR/data.sql" &&
psql -h monorail.proxy.rlwy.net -U postgres -p 59997 -d railway -f "$BASEDIR/user.sql"

