Axis2 Quick Start Guide - Sample 3 (AXIOM)
==========================================

This sample contains source code for the xdocs/1_1/quickstartguide.html document found in 
the extracted Axis2 Documents Distribution. For a more detailed rDescription on the
source code kindly see this 'Axis2 Quick Start Guide' document.

Introduction
============

In this sample, we are deploying an AXIOM based POJO service after writing
a services.xml and creating an aar. We also test successful
deployment using an AXIOM based client.


Pre-Requisites
==============

Apache Ant 1.6.2 or later

Building the Service
====================

Type "ant generate.service" from AXIS2_HOME/samples/quickstartaxiom directory.
Then deploy the 
AXIS2_HOME/samples/quickstartaxiom/build/StockQuoteService.aar


Running the Client
==================

Type ant run.client in the AXIS2_HOME/samples/quickstartaxiom directory

You will get following response
[java] price updated
[java] Current price of WSO: 123.42

Help
====
Please contact axis-user list (axis-user@ws.apache.org) if you have
any trouble running the sample.
