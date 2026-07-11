module.exports = {
    default:{
        requireModule:[
            "ts-node/register"
        ],
        require:[
            "src/resources/world/customworld.ts",
            "src/test/steps/**/*.ts",
            "src/test/hooks/Hooks.ts"
        ],
        formatOptions: {
            snippetInterface: "async-await",
            resultsDir: "reports/allure-results"
        },
        // paths:[
        //     "src/test/features/**/*.feature"
        // ],
        dryRun: false,
        
        format: [
            "progress",
            "json:reports/cucumber-json/cucumber-report.json",
            "html:reports/cucumber-report.html"
        ]
        
    }
}