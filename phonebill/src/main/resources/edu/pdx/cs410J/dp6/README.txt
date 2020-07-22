This program is a phonebill application which takes 5 arguments
                                                                          You must provide a customer name, caller number, callee number, start time, and end time (mm/dd/yyyy mm:hh)
                                                                                  Usage: java edu.pdx.cs410J.<login-id>.Project2 [options] <args>
                                                                                             args are (in this order):
                                                                                                 customer               Person whose phone bill we’re modeling
                                                                                                 callerNumber           Phone number of caller
                                                                                                 calleeNumber           Phone number of person who was called
                                                                                                 startTime              Date and time the call began (24-hour time)
                                                                                                 endTime                Date and time the call ended (24-hour time)
                                                                                             options are (options may appear in any order):
                                                                                                 -textFile file         Where to read/write the phone bill
                                                                                                 -print                 Prints a description of the new phone call
                                                                                                 -README                Prints a README for this project and exits
                                                                                             Date and time should be in the format: mm/dd/yyyy hh:mm