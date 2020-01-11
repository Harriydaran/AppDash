import React from 'react';
import './App.css';
import Sidebar from "./Components/Sidebar";
import DashButton from "./Components/DashButton"

class App extends React.Component {

    componentDidMount() {

    }

    render() {
        return (
            <div className="App">
                <Sidebar/>
                <div className="main">
                    <DashButton name={"Pink"}/>
                </div>
            </div>
        );
    }
}

export default App;
