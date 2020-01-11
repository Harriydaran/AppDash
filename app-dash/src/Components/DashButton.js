import React, {Component} from 'react';
import "./DashButton.css"


class DashButton extends Component {
    render() {
        return (
            <div>
                <a className="myButton" >{this.props.name}</a>
            </div>
        );
    }
}

export default DashButton;