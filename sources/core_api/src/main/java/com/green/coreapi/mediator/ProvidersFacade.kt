package com.green.coreapi.mediator

import com.green.coreapi.database.DatabaseProvider

interface ProvidersFacade : MediatorsProvider, DatabaseProvider, AppProvider